public interface Almacen{
    //saves the data in a warehouse, if there's no space, the process trying to save it is
    //sent to sleep till there's space
    public void almacenar(Producto producto);
    public Producto extraer();
}