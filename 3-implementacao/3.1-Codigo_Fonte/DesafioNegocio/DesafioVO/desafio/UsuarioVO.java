package desafio; 


import java.io.Serializable;

public class UsuarioVO implements Serializable
{ 
    private String email;
    private String senha;
    private boolean isAdministrador;
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public boolean isAdministrador(){
        return this.isAdministrador;
    }
    
    public void setAdministrador(boolean isAdministrador){
        this.isAdministrador = isAdministrador;
    }
} 