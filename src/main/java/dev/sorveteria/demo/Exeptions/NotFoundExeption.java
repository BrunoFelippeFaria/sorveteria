package dev.sorveteria.demo.Exeptions;

public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(String msg){
        super(msg);
    }
}
