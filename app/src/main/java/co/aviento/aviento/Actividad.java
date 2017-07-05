package co.aviento.aviento;


/**
 * Created by parra on 23/04/2017.
 */

public class Actividad
{
    private  String nombre;
    private  int foto;
    private  String descripcion;
    private  Ciudad ciudad;
    private  TipoActividad tipo;
    private  Empresa empresa;
    private  int valor;
    private  float valoracion;

    public Actividad(String nombre, int foto, TipoActividad tipo, String descripcion, Ciudad ciudad, Empresa empresa, int valor, float valoracion)
    {
        this.nombre      = nombre;
        this.foto        = foto;
        this.descripcion = descripcion;
        this.ciudad      = ciudad;
        this.empresa     = empresa;
        this.valoracion  = valoracion;
        this.tipo        = tipo;
        this.valor       = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
