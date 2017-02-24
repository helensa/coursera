package com.example.accountapp.logic;

import com.example.accountapp.ui.OutputInterface;

/**
 * This file defines the Account class.  It provides the basis for a
 * series of improvements you'll need to make as you progress through
 * the lessons in Module 6.
 */
public class Account {
    /**
     * This is the variable that stores our OutputInterface instance.
     * <p/>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * </p>
     * This was renamed to 'mOut' from 'out', as it is in the video
     * lessons, to better match Android/Java naming guidelines.
     */

    /**
     * Constructor initializes the field
     */
    public Account(OutputInterface out) {
        mOut = out;
    }

    //constructor
    public Account (OutputInterface out, String newName, int newNumber){
        this(out);
        name = newName;
        number = newNumber;
    }

    public Account(OutputInterface out, String newName, int newNumber, double newAmount){
        this(out, newName, newNumber);
        balance = newAmount;
    }

    private final OutputInterface mOut;

    /**
     * Name of the account holder.
     */
    private String name;

    /**
     * Number of the account.
     */
    private int number;

    /**
     * Current balance in the account.
     */
    private double balance;

    public String getName(){
        return (name);
    }

    public int getNumber(){
        return (number);
    }

    public double getBalance(){
        return (balance);
    }

    public void setName(String nm){
        name = nm;
    }

    public void setNumber(int num){
        number = num;
    }
    public void Deposit(double amt){
        balance = balance + amt;
    }

    /**
     * Deposit @a amount into the account.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw @a amount from the account.  Prints "Insufficient
     * Funds" if there's not enough money in the account.
     */
    public void withdrawal(double amount) {
        if (balance > amount)
            balance -= amount;
        else 
            mOut.println("Insufficient Funds");
    }

    public boolean withdrawalHelen(double amount) {
        if (balance > amount) {

            balance -= amount;
            return (true);
        }
        else {
            mOut.println("Insufficient Funds");
            return (false);
        }
    }
    /**
     * Display the current @a amount in the account.
     */
    public void displayBalance() {
        mOut.println("The balance on account " 
                     + number
                     + " is " 
                     + balance);
    }
}
