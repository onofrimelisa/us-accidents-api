package com.unlp.bbdd2.accidents.exceptions;

public class NotFoundException extends Exception {

  public NotFoundException() {
    super("The requested resource was not found.");
  }
}
