package com.demo.commons.model;


import java.util.Objects;

public class OrderEvent {
    private String message;
    private String orderStatus;
    private Order order;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderEvent() {
    }

    public OrderEvent(String message, String orderStatus, Order order) {
        this.message = message;
        this.orderStatus = orderStatus;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEvent that = (OrderEvent) o;
        return Objects.equals(message, that.message) && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, orderStatus, order);
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "message='" + message + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", order=" + order +
                '}';
    }
}
