    package uniandes.edu.co.proyecto.modelo;

    import java.io.Serializable;
    import jakarta.persistence.Embeddable;
     
    import jakarta.persistence.ManyToOne;

    @Embeddable
    public class ProductoBodegaPK implements Serializable {
        
        @ManyToOne
        private Producto producto_id;

        @ManyToOne
        private Bodega bodega_id;

        public ProductoBodegaPK(Producto producto_id, Bodega bodega_id) {
            this.producto_id = producto_id;
            this.bodega_id = bodega_id;
        }

        public ProductoBodegaPK() {
        }

        public Producto getId_producto() {
            return producto_id;
        }

        public void setId_producto(Producto producto_id) {
            this.producto_id = producto_id;
        }

        public Bodega getId_bodega() {
            return bodega_id;
        }

        public void setId_bodega(Bodega bodega_id) {
            this.bodega_id = bodega_id;
        }

        
    }
