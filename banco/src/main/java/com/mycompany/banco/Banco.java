/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banco;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author éojuas
 */
public class Banco {

//------------------------------------------------------------------------------
    
    public static boolean cpfSemLetra(String cpf){
        int c = 0;
        
        for(c = 0; c < 11; c++){
            if (!cpf.substring(0,11).matches("[0-9]*")){
                return true;
            }
        }
        
        return false;
    }
    
    public static int buscaNome(String nomes[], String nome){
        int c;
        for(c = 0; c < 10; c++){
            if(nomes[c] != null){
                if(nomes[c].equals(nome)){
                    return c;
                }
            }
            
        }
        
        return -1;
        
    }
    
    public static int buscaCPF(String cpfs[], String cpf){
        int c, cont = 0;
        for(c = 0; c < 10; c++){
            if(cpfs[c].equals(cpf)){
                return cont;
            }
            cont++;
        }
        
        return -1;
        
    }
    
    public static void formataCPF(String cpf){
        int begin = 0;
        int end = 3;
        
        int c = 0;
           String dig3 = cpf.substring(begin, end);
        
        for(c = 0; c <= 3; c++){
        
            switch (c) {
                case 2 -> System.out.print(dig3 + "-");
                case 3 -> System.out.print(dig3 + "\n");
                default -> System.out.print(dig3 + ".");
            }
            
            if(c == 3){
                begin += 0;
                end += 0;
            }else{
                begin += 3;
                end += 3;
            }
            
            dig3 = cpf.substring(begin, end);
            
        }
        
    }
    
    public static int escolheUser(String nome, String cel, String cpf, float saldo){
        int op=0;
        
        System.out.println("Nome: " + nome);
        System.out.println("Celular: " + cel);
        System.out.print("CPF: ");
        formataCPF(cpf);
        System.out.println("Saldo: R$" + saldo);
        
        System.out.print("\nO que deseja fazer?\n\n");
        System.out.print("1 - Adicionar crédito\n2 - Debitar\n3 - Atualizar Celular");
        System.out.print("\n4 - Voltar\n\nEscolha:");
        op = i.nextInt();
        return op;
        
    }
        
    static Scanner i = new Scanner(System.in);
    static Scanner s = new Scanner(System.in);
    static Scanner f = new Scanner(System.in);
    
//------------------------------------------------------------------------------
    
    public static void main(String[] args) {
        boolean temLetra;
        int c=0, cont=0, aa=0;
        int op0 = 0, op1 = 0, op2 = 0, op3 = 0, op4 = 0;
        float saldo[] = new float[11];
        String nome[] = new String[11], cel[] = new String[11];
        String cpf[] = new String[11], search, newCel;
        
//------------------------------------------------------------------------------
        
        System.out.print("=-=-=-=-Bertacander-=-=-=-=\n\n");
        
        op0 = 0;
        while(op0 == 0){
            System.out.print("\n1 - Cadastrar usuário\n2 - Buscar usuário\n");
            System.out.print("0 - Sair\nEscolha: ");
            op1 = i.nextInt();
        
            while(op1 == 0){
                op0 = 1;
                break;
            }
            
            while(op1 == 1){
                if(c > 9){
                    JOptionPane.showMessageDialog(null, "Já atingimos o limite de usuários...\n");
                    break;
                }
                JOptionPane.showMessageDialog(null, "Cadastrando Cliente...");

                nome[c] = JOptionPane.showInputDialog("Nome: ");
                while(true){
                    cpf[c] = JOptionPane.showInputDialog("CPF: ") + " ";
                    if(cpf[c].length() != 12){
                        JOptionPane.showMessageDialog(null, "Informe um cpf valido: ");
                    }else{
                        temLetra = cpfSemLetra(cpf[c]);
                        if(temLetra == true){
                            JOptionPane.showMessageDialog(null, "Informe um cpf valido:");
                        }else{
                            break;
                        }
                    }
                }
                

                cel[c] = JOptionPane.showInputDialog("Celular: ");

                saldo[c] = 0;
                c++;

                aa = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro usuário?");
                if(aa == JOptionPane.NO_OPTION){
                    break;
                }
            }
        
            while(op1 == 2){
                
                JOptionPane.showMessageDialog(null, "Selecionar Usuário");
                System.out.print("\n1 - Buscar por nome\n2 - Buscar por CPF\n");
                System.out.print("3 - Mostrar lista de usuários\n");
                System.out.print("4 - Voltar\n");
                System.out.print("Escolha: ");
                op2 = i.nextInt();
                System.out.print("\n");
                
                if(op2 == 1){
                    search = JOptionPane.showInputDialog("Nome: ");
                    op3 = buscaNome(nome, search);
                    
                    if(op3 == -1){
                        JOptionPane.showMessageDialog(null, "Não foi possível encontrar \"" + search + "\"...");
                        break;
                    }
                }
                
                if(op2 == 2){
                    search = JOptionPane.showInputDialog("CPF: ") + " ";
                    op3 = buscaCPF(cpf, search);
                    
                    if(op3 == -1){
                        JOptionPane.showMessageDialog(null, "Não foi possível encontrar o CPF \"" + search + "\"...");
                        break;
                    }
                }
                
                if(op2 == 3){
                    cont = 0;
                    for(String nome2: nome){
                        if(nome2 != null){
                        System.out.print((cont + 1) + " - " + nome2 + "\n");
                        cont++;
                        }
                    }
                    System.out.print("\nEscolha (1, 2, 3, etc.): ");
                    op3 = i.nextInt()-1;
                }
                
                if(op2 == 4){
                    break;
                }
                
                op4 = escolheUser(nome[op3], cel[op3], cpf[op3], saldo[op3]);
                
                if(op4 == 1){
                    float cred = 0;
                    System.out.print("Saldo atual de " + nome[op3] + ": ");
                    System.out.print(saldo[op3]);
                    System.out.print("\nPara cancelar digite um valor negativo...");
                    System.out.print("\nCrédito à adicionar: R$");
                    cred = f.nextFloat();
                    
                    if(cred <= 0){
                        JOptionPane.showMessageDialog(null, "Nenhum valor foi creditado.");
                        break;
                    }
                    saldo[op3] += cred;
                    JOptionPane.showMessageDialog(null, "Novo saldo de " + nome[op3] + ": R$" + saldo[op3]);
                }
                if(op4 == 2){
                    float deb = 0;
                    System.out.print("Saldo atual de " + nome[op3] + ": ");
                    System.out.print(saldo[op3]);
                    System.out.print("\nPara cancelar digite um valor negativo...");
                    System.out.print("\nValor à debitar: R$");
                    deb = f.nextFloat();
                    if(deb <= 0){
                        JOptionPane.showMessageDialog(null, "Nenhum valor foi debitado.");
                        break;
                    }
                    saldo[op3] -= deb;
                    JOptionPane.showMessageDialog(null, "Novo saldo de " + nome[op3] + ": R$" + saldo[op3]);
                }
                if(op4 == 3){
                    System.out.print("Número de " + nome[op3] + ": ");
                    System.out.print(cel[op3]);
                    System.out.print("\nPara cancelar deixe vazio...");
                    newCel = JOptionPane.showInputDialog("\nNovo número: ");
                    if(newCel.isEmpty()){
                        System.out.print("Numero não foi alterado.");
                        break;
                    }
                    cel[op3] = newCel;
                }
                if(op4 == 4){
                    break;
                }
            }
        }
        System.out.print("\nObrigado por usar Bertacander!");
    }
}
