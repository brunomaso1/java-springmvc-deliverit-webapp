package clases.dominio;

public class RespuestaGeneral {
    public static final int CODIGO_OK = 0; 
    public static final int CODIGO_ERROR = -1;
    public static final int CODIGO_ERROR_VALOR_NULO = -2;
    public static final int CODIGO_ERROR_VALOR_INCORRECTO = -3;
    public static final String MENSAJE_OK = "ok";
    public static final String MENSAJE_VALOR_NULO = " no puede ser nulo.";
    public static final String MENSAJE_VALOR_INCORRECTO = " incorrecto.";
    
    private Integer codigo;
    private String mensaje;
    private Object objeto;
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }  
}