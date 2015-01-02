/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.util.Vector;
import models.Reminder;
import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zianwar
 */
public class ReminderDAO implements DAO<Reminder>{

    
    @Override
    public Reminder find(String id) {
        
        Reminder reminder = new Reminder();
        PatientDAO patientDAO = new PatientDAO();
        
        String findQuery = "SELECT * "
                        + "FROM rappels "
                        + "WHERE id_rappel = " + Integer.parseInt(id) + ";";

        ResultSet rs = database.Database.getInstance().query(findQuery);
            
        try {
            
            rs.first();
            reminder.setId(Integer.parseInt(id));
            reminder.setDescription(rs.getString("desc_rappel"));
            reminder.setPatient(patientDAO.find(id));
            reminder.setDate(rs.getDate("date_rappel"));
            
        } catch (SQLException ex) {
            System.out.println("Error : ReminderDAO.find()" + ex);
        }
        
        return reminder;
    }


    @Override
    public boolean create(Reminder r) {
        
        String insertQuery = "INSERT INTO rappels VALUES("
                           + r.getId()+ ", "
                           + "'" + r.getDescription()+ "', "
                           + "'" + r.getDate()+ "', "
                           + r.getPatient().getPatientId() + ");";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    
    @Override
    public boolean update(Reminder r) {
        
        String updateQuery = "UPDATE rappels "
                          + "SET desc_rappel = " + "'" + r.getDescription()+ "', "
                          + "date_rappel = '" + r.getDate() + "', "
                          + "id_patient = " + r.getPatient().getPatientId() + " "
                          + "WHERE id_rappel = " + r.getId() + ";";
        
        return (Database.getInstance().dmlQuery(updateQuery) == 0);
    }

    
    @Override
    public boolean delete(Reminder r) {
        
        String deleteQuery = "DELETE FROM rappels "
                          + "WHERE id_rappel = " + r.getId() + ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) == 0);
    }
    
    
    @Override
    public Vector<Reminder> all() {
        
        Vector<Reminder> reminders = new Vector<Reminder>();
        PatientDAO patientDAO = new PatientDAO();

        String findQuery = "SELECT * "
                        + "FROM rappels;";
        
        ResultSet rs = database.Database.getInstance().query(findQuery);

        try {
            
            while(rs.next()) {
                
                Reminder reminder = new Reminder();
                
                reminder.setId(rs.getInt("id_rappel"));
                reminder.setDescription(rs.getString("desc_rappel"));
                reminder.setPatient(patientDAO.find(rs.getString("id_patient")));
                reminder.setDate(rs.getDate("date_rappel"));
            
                reminders.add(reminder);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error : ReminderDAO.all()" + ex);
        }
        
        return reminders;
    }
    
    
}