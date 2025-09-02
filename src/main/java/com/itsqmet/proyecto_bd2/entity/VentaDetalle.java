package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

        @ManyToOne
        @JoinColumn(name = "id_venta")
        private Venta venta;

        @ManyToOne
        @JoinColumn(name = "id_producto")
        private Producto producto;


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

        public Venta getVenta() {
                return venta;
        }

        public void setVenta(Venta venta) {
                this.venta = venta;
        }

        public Producto getProducto() {
                return producto;
        }

        public void setProducto(Producto producto) {
                this.producto = producto;
        }
}
