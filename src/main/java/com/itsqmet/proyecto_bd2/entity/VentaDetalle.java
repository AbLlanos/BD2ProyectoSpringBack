package com.itsqmet.proyecto_bd2.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ventaDetalle")
@Data
public class VentaDetalle {

        @Id
        private String id_detalle;

        private int cantidad;
        private double precio_unitario;
        private double subtotal;

        //Para Mongo
        private String id_venta;
        private String id_producto;


        public String getId_detalle() {
                return id_detalle;
        }

        public void setId_detalle(String id_detalle) {
                this.id_detalle = id_detalle;
        }

        public int getCantidad() {
                return cantidad;
        }

        public void setCantidad(int cantidad) {
                this.cantidad = cantidad;
        }

        public double getPrecio_unitario() {
                return precio_unitario;
        }

        public void setPrecio_unitario(double precio_unitario) {
                this.precio_unitario = precio_unitario;
        }

        public double getSubtotal() {
                return subtotal;
        }

        public void setSubtotal(double subtotal) {
                this.subtotal = subtotal;
        }

        public String getId_venta() {
                return id_venta;
        }

        public void setId_venta(String id_venta) {
                this.id_venta = id_venta;
        }

        public String getId_producto() {
                return id_producto;
        }

        public void setId_producto(String id_producto) {
                this.id_producto = id_producto;
        }
}
