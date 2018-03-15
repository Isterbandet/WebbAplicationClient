
package com.mycompany.webbaplicatoncomputer;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="kompisar")

public class Kompisar implements Serializable{
    private static final long serialVersionUID = 1L;
    private String namn;
    private int nummer;
    
    public Kompisar () {}
    
    public Kompisar(String namn, int nummer){
        this.namn = namn;
        this.nummer = nummer;
  
    }
    @XmlElement
    public String getNamn() {
        return namn;
    }
    @XmlElement
    public void setName(String namn){
        this.namn = namn;
    }
    @XmlElement
    public int getNummer() {
        return nummer;
    }


    @XmlElement
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    
}
