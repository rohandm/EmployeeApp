/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.exception;

/**
 * Custom exception class
 * @author rohan_000
 */
public class EmpAppException extends Exception{
    public EmpAppException(String message){
         super(message);
    }
}
