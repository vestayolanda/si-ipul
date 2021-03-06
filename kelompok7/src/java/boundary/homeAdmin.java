/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarLapangan;
import entity.DaftarUser;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class homeAdmin extends Boundary {
    private operator operator;

    public homeAdmin() {
        super();
        setTemplate("/WEB-INF/homeAdmin.jsp");
    }

    @Override
    protected void process() {
        HttpSession session = getRequest().getSession();
        members user = new members();
        DaftarUser du = new DaftarUser();
        if (check()){
        //if (session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username.username");
            user = du.getMember(username);
        } else {
            try {
                getResponse().sendRedirect("loginAd");
            } catch (IOException ex) {
                Logger.getLogger(homeAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
        boolean check() {
        DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        String u = (String) session.getAttribute("username");
        if (dm.getAdmin(u) != null ) {
            return true;
        }
        return false;
    }  
        
    private boolean validate_lapangan(){
        DaftarLapangan dl = new DaftarLapangan();
        int xx = dl.getJumlahLapangan();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
    }

