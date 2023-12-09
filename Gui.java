import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Esta classe representa a interface gráfica do jogo POOTrivia.
 * Ela inclui elementos como botões, rótulos e campos de texto para interação do usuário.
 * Além disso, gerencia o progresso do jogo, as respostas do jogador e as pontuações.
 *
 * @author Joao Furukawa
 * @author Mateus Lima
 * @version 1.0
 */
public class Gui extends Potrivia implements ActionListener{
    /**
     * Cor utilizada para os botões.
    */
    private Color corBotao = new Color(25, 25, 25);
    /**
     * Cor utilizada para o texto.
    */
    private Color corTexto = new Color(100,100,100);
    /**
     * Janela principal da interface gráfica.
     */
    private JFrame frame = new JFrame();
    /**
     * Botões para as opções de resposta.
     */
    private JButton botaoOpc1 = new JButton();
    private JButton botaoOpc2 =  new JButton();
    private JButton botaoOpc3 = new JButton();
    private JButton botaoOpc4 = new JButton();
    /**
     * Rótulos para exibir as opções de resposta.
     */
    private JLabel answer_Alt1 = new JLabel();
    private JLabel answer_Alt2 = new JLabel();
    private JLabel answer_Alt3 = new JLabel();
    private JLabel answer_Alt4 = new JLabel();
    /**
     * Campo de texto para exibir o índice da pergunta.
     */
    private JTextField questionIndex = new JTextField();
    /**
     * Área de texto para exibir a pergunta.
     */
    private JEditorPane questionText = new JTextPane();
    /**
     * Botão para salvar os dados do jogo.
     */
    private JButton save = new JButton("Guardar");
    /**
     * Índice atual do jogo.
     */
    int indGUI = 0;
    /**
     * Lista de perguntas respondidas corretamente.
     */
    ArrayList<Pergunta> perguntCertas = new ArrayList<Pergunta>(5);
    /**
     * Lista de perguntas respondidas incorretamente.
     */
    ArrayList<Pergunta> perguntErradas = new ArrayList<Pergunta>(5);
    /**
     * Lista de todas as perguntas do jogo.
     */
    ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>(5);
    /**
     * Lista de respostas do jogador.
     */
    ArrayList<String> arrDeResposta = new ArrayList<String>(5);
    /**
     * Lista de nomes de usuário dos jogadores.
     */
    ArrayList<String> usernames = new ArrayList<>();
    /**
     * Lista de pontuações dos jogadores.
     */
    ArrayList<Integer> pontuacoes = new ArrayList<>();

    /**
     * Construtor da classe Gui.
     * Inicializa os elementos da interface gráfica e configura a interação do usuário.
     *
     * @param index Índice inicial do jogo.
     * @param perguntas Lista de perguntas para o jogo.
     * @param shuffleArray Lista de opções de resposta embaralhadas.
     */
    public Gui(int index, ArrayList<Pergunta> perguntas, ArrayList<String> shuffleArray){
        this.indGUI = index;
        this.perguntas = perguntas;
        this.arrDeResposta = shuffleArray;
    }
    /**
     * Configura a interface gráfica.
     *
     * @param shuffleOpc A lista de opções embaralhadas.
     */
    protected void setGui(ArrayList<String> shuffleArray){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(655,655);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("POOTrivia");

        questionIndex.setBounds(0, 0, 650, 75);
        questionIndex.setBackground(corBotao);
        questionIndex.setForeground(corTexto);
        questionIndex.setFont(new Font("Arial", Font.BOLD, 30));
        questionIndex.setBorder(BorderFactory.createBevelBorder(1));
        questionIndex.setHorizontalAlignment(JTextField.CENTER);
        questionIndex.setEditable(false);

        questionText.setBounds(0, 75, 650, 65);
        questionText.setBackground(corBotao);
        questionText.setForeground(corTexto);
        questionText.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        questionText.setBorder(BorderFactory.createBevelBorder(1));
        questionText.setEditable(false);

        botaoOpc1.setBounds(0, 150, 100, 100);
        botaoOpc1.setBackground(corBotao);
        botaoOpc1.setForeground(corTexto);
        botaoOpc1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        botaoOpc1.setFocusable(false);
        botaoOpc1.addActionListener(this);
        botaoOpc1.setText("A");

        botaoOpc2.setBounds(0, 250, 100, 100);
        botaoOpc2.setBackground(corBotao);
        botaoOpc2.setForeground(corTexto);
        botaoOpc2.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        botaoOpc2.setFocusable(false);
        botaoOpc2.addActionListener(this);
        botaoOpc2.setText("B");

        botaoOpc3.setBounds(0, 350, 100, 100);
        botaoOpc3.setBackground(corBotao);
        botaoOpc3.setForeground(corTexto);
        botaoOpc3.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        botaoOpc3.setFocusable(false);
        botaoOpc3.addActionListener(this);
        botaoOpc3.setText("C");

        botaoOpc4.setBounds(0, 450, 100, 100);
        botaoOpc4.setBackground(corBotao);
        botaoOpc4.setForeground(corTexto);
        botaoOpc4.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        botaoOpc4.setFocusable(false);
        botaoOpc4.addActionListener(this);
        botaoOpc4.setText("D");

        answer_Alt1.setBounds(125, 150, 523, 100);
        answer_Alt1.setBackground(corBotao);
        answer_Alt1.setForeground(corTexto);
        answer_Alt1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        answer_Alt1.setBorder(BorderFactory.createBevelBorder(1));
        answer_Alt1.setHorizontalAlignment(JTextField.CENTER);
        answer_Alt1.setOpaque(true);

        answer_Alt2.setBounds(125, 250, 523, 100);
        answer_Alt2.setBackground(corBotao);
        answer_Alt2.setForeground(corTexto);
        answer_Alt2.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        answer_Alt2.setBorder(BorderFactory.createBevelBorder(1));
        answer_Alt2.setHorizontalAlignment(JTextField.CENTER);
        answer_Alt2.setOpaque(true);

        answer_Alt3.setBounds(125, 350, 523, 100);
        answer_Alt3.setBackground(corBotao);
        answer_Alt3.setForeground(corTexto);
        answer_Alt3.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        answer_Alt3.setBorder(BorderFactory.createBevelBorder(1));
        answer_Alt3.setHorizontalAlignment(JTextField.CENTER);
        answer_Alt3.setOpaque(true);

        answer_Alt4.setBounds(125, 450, 523, 100);
        answer_Alt4.setBackground(corBotao);
        answer_Alt4.setForeground(corTexto);
        answer_Alt4.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        answer_Alt4.setBorder(BorderFactory.createBevelBorder(1));
        answer_Alt4.setHorizontalAlignment(JTextField.CENTER);
        answer_Alt4.setOpaque(true);

        frame.add(questionText);
        frame.add(questionIndex);
        save.setVisible(false);
        save.setEnabled(false);
        frame.setVisible(true);

        nextQuestion(indGUI, perguntas, shuffleArray);
    }
    /**
    * Avança para a próxima pergunta no jogo Potrivia.
    *
    * @param index         O índice da pergunta atual.
    * @param perguntas     A lista de perguntas.
    * @param shuffleArray  A lista de opções embaralhadas.
    */
    private void nextQuestion(int index, ArrayList<Pergunta> perguntas, ArrayList<String> shuffleArray){
        if (index >= 5){ //Se ja tiverem sido feitas as 5 perguntas
            printRespostas();
            return;
        }else if (perguntas.get(index).getSubtipo() == 1 && index <= 3){ //Se for de desporto e antes da 4ª pergunta
            escolheOpcoes(index,perguntas.get(index).getOpcoes(),perguntas.get(index).getResposta(), shuffleArray,3);
        }else if (perguntas.get(index).getSubtipo() == 1 && index > 3){ //Se for de desporto e depois da 4ª pergunta
            escolheOpcoes(index,perguntas.get(index).getOpcoesEz(),perguntas.get(index).getResposta2(), shuffleArray,3);
        }else if (perguntas.get(index).getTipo() == 2 && index < 3){ //Se for de ciencia e antes da 4ª pergunta
            escolheOpcoes(index,perguntas.get(index).getOpcoesEz(),perguntas.get(index).getResposta(), shuffleArray,2);
        }else if(perguntas.get(index).getTipo() == 3 && perguntas.get(index).getSubtipo() != 1){ //Se o tipo for Desporto e nao for de Futebol
            shuffleArray.add(perguntas.get(index).opcoes[0]); //Adiciona Verdadeiro
            shuffleArray.add(perguntas.get(index).opcoes[1]); //Adiciona Falso
        }else{//Se for de artes e ciencias depois da 4ª pergunta
            escolheOpcoes(index,perguntas.get(index).opcoes,perguntas.get(index).getResposta(), shuffleArray,perguntas.get(index).getTipo());
        }
        questionIndex.setText("Pergunta " + (index+1) + " de 5");
        questionText.setText(perguntas.get(index).getPergunta());
        switch (shuffleArray.size()) {
            case 2:
                frame.add(answer_Alt1);
                frame.add(answer_Alt2);
                frame.add(botaoOpc1);
                frame.add(botaoOpc2);
                botaoOpc1.setEnabled(true);
                botaoOpc2.setEnabled(true);
                botaoOpc3.setEnabled(false);
                botaoOpc3.setVisible(false);
                botaoOpc4.setEnabled(false);
                botaoOpc4.setVisible(false);

                answer_Alt1.setText(shuffleArray.get(0));
                answer_Alt2.setText(shuffleArray.get(1));

                answer_Alt3.setText("");
                answer_Alt3.setVisible(false);
                answer_Alt4.setText("");
                answer_Alt4.setVisible(false);

                break;
            case 3:
                frame.add(answer_Alt1);
                frame.add(answer_Alt2);
                frame.add(answer_Alt3);
                
                frame.add(botaoOpc1);
                frame.add(botaoOpc2);
                frame.add(botaoOpc3);

                answer_Alt1.setText(shuffleArray.get(0));
                answer_Alt2.setText(shuffleArray.get(1));
                answer_Alt3.setText(shuffleArray.get(2));
                answer_Alt3.setVisible(true);
                answer_Alt4.setText("");
                answer_Alt4.setVisible(false);

                botaoOpc1.setEnabled(true);
                botaoOpc2.setEnabled(true);
                botaoOpc3.setEnabled(true);
                botaoOpc3.setVisible(true);
                botaoOpc4.setEnabled(false);
                botaoOpc4.setVisible(false);
                break;

            case 4:
                frame.add(answer_Alt1);
                frame.add(answer_Alt2);
                frame.add(answer_Alt3);
                frame.add(answer_Alt4);
                frame.add(botaoOpc1);
                frame.add(botaoOpc2);
                frame.add(botaoOpc3);
                frame.add(botaoOpc4);

                answer_Alt1.setText(shuffleArray.get(0));
                answer_Alt2.setText(shuffleArray.get(1));
                answer_Alt3.setText(shuffleArray.get(2));
                answer_Alt3.setVisible(true);
                answer_Alt4.setText(shuffleArray.get(3));
                answer_Alt4.setVisible(true);

                botaoOpc1.setEnabled(true);
                botaoOpc2.setEnabled(true);
                botaoOpc3.setEnabled(true);
                botaoOpc3.setVisible(true);
                botaoOpc4.setEnabled(true);
                botaoOpc4.setVisible(true);

                    break;
                default:
                    break;
            }
        }
    /**
     * Método actionPerformed para lidar com eventos de botões.
     *
     * @param e O evento de ação.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        botaoOpc1.setEnabled(false);
        botaoOpc2.setEnabled(false);
        botaoOpc3.setEnabled(false);
        botaoOpc4.setEnabled(false);
        if(e.getSource()==botaoOpc1){
            answer_Alt1.setForeground(Color.GREEN);
            if(answer_Alt1.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt1.getText().equals(perguntas.get(indGUI).getResposta2())	){
                perguntCertas.add(perguntas.get(indGUI));
            }
            else{
                perguntErradas.add(perguntas.get(indGUI));
            }
        }
        if(e.getSource()==botaoOpc2){
            answer_Alt2.setForeground(Color.GREEN);
            if(answer_Alt2.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt2.getText().equals(perguntas.get(indGUI).getResposta2())	){
                perguntCertas.add(perguntas.get(indGUI));
            }
            else{
                perguntErradas.add(perguntas.get(indGUI));
            }
        }
        if(e.getSource()==botaoOpc3){
            answer_Alt3.setForeground(Color.GREEN);
            if(answer_Alt3.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt3.getText().equals(perguntas.get(indGUI).getResposta2())){
                perguntCertas.add(perguntas.get(indGUI));
            }
            else{
                perguntErradas.add(perguntas.get(indGUI));
            }
        }
        if(e.getSource()==botaoOpc4){
            answer_Alt4.setForeground(Color.GREEN);
            if(answer_Alt4.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt4.getText().equals(perguntas.get(indGUI).getResposta2())){
                perguntCertas.add(perguntas.get(indGUI));
            }
            else{
                perguntErradas.add(perguntas.get(indGUI));
            }
        }
        resultados();
    }
    /**
    * Apresenta os resultados após o jogador responder a uma pergunta no jogo Potrivia.
    */
    private void resultados(){
        // Desabilita os botões durante a apresentação dos resultados
        botaoOpc1.setEnabled(false);
        botaoOpc2.setEnabled(false);
        botaoOpc3.setEnabled(false);
        botaoOpc4.setEnabled(false);

        showCorrectAnswer();
        showWrongAnswer();
        // Cria um temporizador para aguardar antes de avançar para a próxima pergunta
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            // Redefine as cores dos textos e habilita os botões
            public void actionPerformed(ActionEvent e){
                answer_Alt1.setForeground(corTexto);
                answer_Alt2.setForeground(corTexto);
                answer_Alt3.setForeground(corTexto);
                answer_Alt4.setForeground(corTexto);

                botaoOpc1.setEnabled(true);
                botaoOpc2.setEnabled(true);
                botaoOpc3.setEnabled(true);
                botaoOpc4.setEnabled(true);
                // Avança para a próxima pergunta
                indGUI+=1;
                arrDeResposta.clear();
                nextQuestion(indGUI, perguntas, arrDeResposta);
            }
        });
        // Define para não repetir o temporizador
        pause.setRepeats(false);
         // Inicia o temporizador
        pause.start();
    }
    /**
    * Destaca a resposta correta após o jogador responder a uma pergunta.
    */
    private void showCorrectAnswer(){
        // Verifica se a opção 1 contém a resposta correta
        if(answer_Alt1.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt1.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt1.setForeground(Color.GREEN);
        }
        // Verifica se a opção 2 contém a resposta correta
        if(answer_Alt2.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt2.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt2.setForeground(Color.GREEN);
        }
        // Verifica se a opção 3 contém a resposta correta
        if(answer_Alt3.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt3.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt3.setForeground(Color.GREEN);
        }
        // Verifica se a opção 4 contém a resposta correta
        if(answer_Alt4.getText().equals(perguntas.get(indGUI).getResposta()) || answer_Alt4.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt4.setForeground(Color.GREEN);
        }
    }
    /**
    * Destaca as respostas erradas após o jogador responder a uma pergunta.
    */
    private void showWrongAnswer(){
        // Verifica se a opção 1 contém uma resposta errada
        if(!answer_Alt1.getText().equals(perguntas.get(indGUI).getResposta()) && !answer_Alt1.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt1.setForeground(Color.RED);
        }
        // Verifica se a opção 2 contém uma resposta errada
        if(!answer_Alt2.getText().equals(perguntas.get(indGUI).getResposta()) && !answer_Alt2.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt2.setForeground(Color.RED);
        }
        // Verifica se a opção 3 contém uma resposta errada
        if(!answer_Alt3.getText().equals(perguntas.get(indGUI).getResposta()) && !answer_Alt3.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt3.setForeground(Color.RED);
        }
        // Verifica se a opção 4 contém uma resposta errada
        if(!answer_Alt4.getText().equals(perguntas.get(indGUI).getResposta()) && !answer_Alt4.getText().equals(perguntas.get(indGUI).getResposta2())){
            answer_Alt4.setForeground(Color.RED);
        }
    }
    /**
    * Exibe as respostas corretas e incorretas, permite que o jogador salve os dados
    * e realiza ações como calcular pontuações, mostrar pontuações e exibir o top 3.
    */
    private void printRespostas(){
         // Define as propriedades do botão "Guardar"
        save.setBounds(0, 550, 650, 50);
        save.setBackground(corBotao);
        save.setForeground(corTexto);
        save.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        save.setFocusable(false);
        save.setEnabled(true);
        save.setVisible(true);
        // Adiciona o botão à interface gráfica
        frame.add(save);
        // Adiciona um ActionListener ao botão "Guardar"
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém a data e hora atuais
                LocalDateTime data = LocalDateTime.now();
                // Formata a data e hora como uma string
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String formatDateTime = data.format(formatter);
                // Obtém o nome de usuário do jogador
                String username = perguntaUsername();
                // Salva os dados, calcula e mostra a pontuação e exibe o top 3
                salvarDados(perguntCertas, perguntErradas, username, data, formatDateTime);
                calcularPontuacao(perguntCertas);
                top3(siglaUsername(username));
                int escolha = JOptionPane.showOptionDialog(frame, "Quer jogar de novo?", "Novo jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (escolha == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    // Reinicia o programa
                    iniciaOPrograma();
                } else {
                    // Encerra o programa
                    System.exit(0);
                }
            }
        });
         // Desabilita os botões de opção após exibir as respostas
        botaoOpc1.setEnabled(false);
        botaoOpc2.setEnabled(false);
        botaoOpc3.setEnabled(false);
        botaoOpc4.setEnabled(false);
    }
    /**
    * Salva os dados do jogo, incluindo perguntas certas, perguntas erradas, nome de usuário,
    * data e hora em um arquivo binário.
    * @param perguntasCertas Lista de perguntas respondidas corretamente.
    * @param perguntasErradas Lista de perguntas respondidas incorretamente.
    * @param username Nome de usuário do jogador.
    * @param data Data e hora atuais.
    * @param formataData Data e hora formatadas como string.
    */
    private void salvarDados(ArrayList<Pergunta> perguntasCertas, ArrayList<Pergunta> perguntasErradas, String username, LocalDateTime data, String formataData){
        // Gera uma sigla a partir do nome de usuário
        String sigla = siglaUsername(username);
        // Define o nome do arquivo usando a data formatada e a sigla
        String nomeFicheiro ="pootrivia_jogo_"+formataData+"_"+sigla+".dat";
        try {
            // Cria os fluxos necessários para a serialização
            FileOutputStream fos = new FileOutputStream(nomeFicheiro);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            // Cria um objeto DataStore para armazenar os dados
            DataStore dStore = new DataStore();
            // Preenche o objeto DataStore com os dados relevantes
            dStore.username = sigla;
            dStore.data = data;
            dStore.perguntasCertas = perguntasCertas;
            dStore.perguntasErradas = perguntasErradas;
            // Realiza a serialização e fecha os fluxos
            oos.writeObject(dStore);
            oos.close();
            // Exibe uma mensagem de sucesso ao usuário
            JOptionPane.showMessageDialog(frame, "Dados guardados com sucesso!");
        } catch (IOException e) {
            // Trata exceções de IO exibindo o rastreamento de pilha
            e.printStackTrace();
        }
    }
    /**
    * Gera uma sigla a partir do nome de usuário, utilizando as iniciais de cada palavra.
    * @param username Nome de usuário a ser convertido em sigla.
    * @return A sigla gerada.
    */
    private String siglaUsername(String username){
         // Inicializa a sigla como uma string vazia
        String sigla = "";
        // Divide o nome de usuário em palavras usando o espaço como delimitador
        String[] nomes = username.split(" ");
        // Itera sobre as palavras e adiciona as iniciais à sigla em maiúsculas
        for (int i = 0; i < nomes.length; i++) {
            sigla += nomes[i].toUpperCase().charAt(0);
        }
        // Retorna a sigla gerada
        return sigla;
    }
    /**
    * Pede ao usuário para inserir o nome e retorna o valor inserido.
    * @return O nome inserido pelo usuário.
    */
    private String perguntaUsername(){
        String username = JOptionPane.showInputDialog(frame, "Insira o seu nome: ", "POOTrivia", JOptionPane.PLAIN_MESSAGE);
        return username;
    }
    /**
    * Calcula a pontuação total com base em uma lista de perguntas acertadas.
    *
    * @param perguntasCertas Lista de perguntas que o usuário acertou.
    * @return A pontuação total.
    */
    private int calcularPontuacao(ArrayList<Pergunta> perguntasCertas){
        int pontuacao = 0;
        for (Pergunta pergunta : perguntasCertas) {
            pontuacao += pergunta.calculaPontos();
        }
       return pontuacao;
    }
    /**
    * Carrega dados de um arquivo serializado e atualiza as listas de usuários e pontuações.
    *
    * @param datFile O arquivo de dados serializados a ser carregado.
    */
    private void carregarDados(File datFile){
        try {
            FileInputStream fis = new FileInputStream(datFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            // Lê o objeto DataStore do arquivo
            DataStore dStore = (DataStore) ois.readObject();
            // Adiciona o nome de usuário à lista de usuários
            usernames.add(dStore.username);
            // Calcula a pontuação se houver perguntas certas, caso contrário, adiciona 0
            if (dStore.perguntasCertas.size() > 0){
                pontuacoes.add(calcularPontuacao(dStore.perguntasCertas));
            }else{
                pontuacoes.add(0);
            }
            
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }   
    /**
    * Carrega dados de todos os arquivos .dat no diretório atual e atualiza as listas de usuários e pontuações.
    */
    private void carregaDados(){
        // Obtém o diretório de trabalho atual
        String currentDir = System.getProperty("user.dir");
        // Lista todos os arquivos .dat no diretório atual
        File[] datFiles =new File (currentDir).listFiles((dir, name) -> name.endsWith(".dat"));
        // Verifica se há arquivos .dat no diretório
        if (datFiles.length == 0){
            JOptionPane.showMessageDialog(frame, "Não existem dados guardados!");
        }else{
            // Itera sobre cada arquivo .dat e carrega os dados
            for (int i = 0; i < datFiles.length; i++) {
                carregarDados(datFiles[i]);
            }
        }   
    }
    /**
    * Exibe a classificação dos três melhores jogadores (Top 3) com base nas pontuações.
    */
    private void top3(String username){
        // Carrega os dados dos arquivos .dat
        carregaDados();
        // Ordena as pontuações em ordem decrescente usando o algoritmo Bubble Sort
        bubbleSort(pontuacoes, usernames);
        for (int i = 0; i < usernames.size(); i++) {
            // Verifica se o nome de usuário atual é o mesmo que o nome de usuário inserido
            if (usernames.get(i).equals(username)){
                // Exibe a classificação do jogador e o top 3
                JOptionPane.showMessageDialog(frame, "Top 3:\n1º - " + usernames.get(0) + " - " + pontuacoes.get(0) + " pontos\n2º - " + usernames.get(1) + " - " + pontuacoes.get(1) + " pontos\n3º - " + usernames.get(2) + " - " + pontuacoes.get(2) + " pontos\n"+ "Sua posição:\n" + (i+1) + "º - "+ usernames.get(i) +" - "+ pontuacoes.get(i) + " pontos");
                return;
            }
        }
    }
    /**
    * Ordena duas listas (pontuações e nomes de usuário) em ordem decrescente de pontuação usando o algoritmo Bubble Sort.
    *
    * @param pontuacoes Lista de pontuações dos jogadores.
    * @param usernames Lista de nomes de usuário dos jogadores.
    */
    private static void bubbleSort(ArrayList<Integer> pontuacoes, ArrayList<String> usernames){
        int n = pontuacoes.size();
        boolean trocou;
        do{
            trocou = false;
            for (int i = 0; i < n-1; i++) {
                if (pontuacoes.get(i) < pontuacoes.get(i+1)){
                    // Troca as pontuações
                    int temp = pontuacoes.get(i);
                    pontuacoes.set(i, pontuacoes.get(i+1));
                    pontuacoes.set(i+1, temp);
                    // Troca os nomes de usuário correspondentes
                    String temp2 = usernames.get(i);
                    usernames.set(i, usernames.get(i+1));
                    usernames.set(i+1, temp2);

                    trocou = true;
                }
            }
            n--;
    }while(trocou);
    }
}