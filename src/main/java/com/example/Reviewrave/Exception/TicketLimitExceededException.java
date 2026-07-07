package com.example.Reviewrave.Exception;

public class TicketLimitExceededException extends RuntimeException {
    
 public TicketLimitExceededException(String message){
    super(message);
 }

}
