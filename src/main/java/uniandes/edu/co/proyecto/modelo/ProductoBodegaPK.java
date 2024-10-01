    package uniandes.edu.co.proyecto.modelo;

    import java.io.Serializable;
    import jakarta.persistence.Embeddable;
     
    import jakarta.persistence.ManyToOne;

    @Embeddable
    public class ProductoBodegaPK implements Serializable {
        
        @ManyToOne
        private Producto id_producto;

        @ManyToOne
        private Bodega id_bodega;

        public ProductoBodegaPK(Producto id_producto, Bodega id_bodega) {
            this.id_producto = id_producto;
            this.id_bodega = id_bodega;
        }

        public ProductoBodegaPK() {
        }

        public Producto getId_producto() {
            return id_producto;
        }

        public void setId_producto(Producto id_producto) {
            this.id_producto = id_producto;
        }

        public Bodega getId_bodega() {
            return id_bodega;
        }

        public void setId_bodega(Bodega id_bodega) {
            this.id_bodega = id_bodega;
        }

        
    }
