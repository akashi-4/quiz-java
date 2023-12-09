import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
/**
 * Classe principal do jogo Potrivia.
 *
 * @version 1.0
 * @author Joao Furukawa 
 * @author Mateus Lima
 */
public class Potrivia {
     /**
     * Método principal que inicia o jogo Potrivia.
     *
     * @param args Os argumentos de linha de comando (não utilizados neste momento).
     */
    public static void main(String[] args) {
        iniciaOPrograma();
    }
    protected static void iniciaOPrograma(){
        ArrayList<String> shuffleOpc = new ArrayList<String>(5);
        ArrayList<Pergunta> perguntasEscolh = new ArrayList<Pergunta>(5);
        ArrayList<Pergunta> todasPerguntas = new ArrayList<Pergunta>(5);
        int index = 0;
        leFicheiro(todasPerguntas);
        escolhe5Perguntas(todasPerguntas, perguntasEscolh);
        Gui gui = new Gui(index, perguntasEscolh, shuffleOpc);
        gui.setGui(shuffleOpc);
    }
    /**
     * Gera opções embaralhadas para uma pergunta.
     *
     * @param index        O índice da pergunta.
     * @param opcoes       As opções originais da pergunta.
     * @param resposta     A resposta correta da pergunta.
     * @param shuffleArray Lista para armazenar as opções embaralhadas.
     * @param tipo         O tipo da pergunta.
     * @return A lista de opções embaralhadas.
     */
    protected static ArrayList<String> escolheOpcoes(int index,String[] opcoes,String resposta, ArrayList<String> shuffleArray, int tipo){
        if (shuffleArray.size() == 2){ //Se for de desporto de V ou F
            return shuffleArray;
        }
        for (int i = 0; i < opcoes.length; i++) { //Adiciona as opções ao array
            shuffleArray.add(opcoes[i]);
        }
        if (index < 3 && tipo == 1){ //Se for de artes e antes da 4ª pergunta tira uma alternativa
            shuffleArray.remove(shuffleArray.size()-1);
        }
        Collections.shuffle(shuffleArray); //Mistura as opções
        int random = (int) (Math.random() * shuffleArray.size()); //Escolhe uma posição aleatória
        shuffleArray.set(random, resposta); //Substitui a opção aleatória pela resposta para garantir que a resposta está entre as opcoes
        return shuffleArray;
    }
    /**
     * Escolhe aleatoriamente 5 perguntas a partir de uma lista de todas as perguntas.
     *
     * @param todasPerguntas Lista de todas as perguntas disponíveis.
     * @param perguntasEscolh Lista para armazenar as 5 perguntas escolhidas.
     */
    private static void escolhe5Perguntas(ArrayList<Pergunta> todasPerguntas, ArrayList<Pergunta> perguntasEscolh){
        ArrayList<Pergunta> arrAux = new ArrayList<>(List.copyOf(todasPerguntas));
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * arrAux.size());
            perguntasEscolh.add(arrAux.get(random));
            arrAux.remove(random);
        }
    }
    /**
     * Lê perguntas de um arquivo e inicializa a lista de perguntas.
     *
     * @param perguntas Lista para armazenar as perguntas lidas do arquivo.
     */
    private static void leFicheiro(ArrayList<Pergunta> perguntasEscolh){
        try{
            File f = new File("perguntas.txt");
            Scanner scf = new Scanner(f);
            while (scf.hasNextLine()){
                String a = scf.nextLine();
                inicializaArray(perguntasEscolh, a);
            }
            scf.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Ficheiro não encontrado");
        }
    }
    /**
     * Inicializa a lista de perguntas com base nos dados fornecidos.
     *
     * @param perguntas Lista para armazenar as perguntas inicializadas.
     * @param a         String contendo os dados da pergunta.
     */
    private static void inicializaArray(ArrayList<Pergunta> perguntas, String a){
        Pergunta aux = new Pergunta();
        aux.leInput(a);
        if (aux.tipo == 1){
            perguntas.add(new Artes(aux.pergunta, aux.resposta, aux.opcoes));
        }
        else if (aux.tipo == 2){
            perguntas.add(new Ciencias(aux.pergunta, aux.resposta, aux.opcoes,aux.opcoesEz));
        }
        else if(aux.subtipo == 1){
            perguntas.add(new Futebol(aux.pergunta, aux.resposta, aux.opcoes, aux.opcoesEz,aux.resposta2));
        }
        else if (aux.subtipo == 2){
            perguntas.add(new Ski(aux.pergunta, aux.resposta, aux.opcoes));
        }
        else if (aux.subtipo == 3){
            perguntas.add(new Natacao(aux.pergunta, aux.resposta, aux.opcoes));
        }
    }
}
