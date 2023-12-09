import java.io.Serializable;
/**
 * Classe que representa uma pergunta.
 *
 * @version 1.0
 * @author Joao Furukawa
 * @author Mateus Lima
 */
public class Pergunta implements Serializable{
// Membros da classe

    /**
     * Texto da pergunta.
     */
    protected String pergunta;

    /**
     * Resposta correta da pergunta.
     */
    protected String resposta;

    /**
     * Opções de resposta da pergunta.
     */
    protected String[] opcoes = new String[4];

    /**
     * Opções fáceis de resposta da pergunta.
     */
    protected String[] opcoesEz = new String[4];

    /**
     * Valor de majoração associado à pergunta.
     */
    protected int majoracao;

    /**
     * Tipo da pergunta (1 para Artes, 2 para Ciências, 3 para Desporto).
     */
    protected int tipo;

    /**
     * Pontuação inicial da pergunta.
     */
    protected int pontos = 5;

    /**
     * Subtipo da pergunta (1 para Futebol, 2 para Ski, 3 para Natação).
     */
    protected int subtipo;

    /**
     * Resposta adicional associada a perguntas específicas.
     */
    protected String resposta2;
    /**
     * Construtor padrão sem parâmetros.
     */
    public Pergunta(){

    }

    /**
     * Construtor para perguntas sem subtipo.
     *
     * @param tipo     O tipo da pergunta (1 para Artes, 2 para Ciências, 3 para Desporto).
     * @param pergunta O texto da pergunta.
     * @param resposta A resposta correta da pergunta.
     * @param opcoes   As opções de resposta da pergunta.
     */
    public Pergunta(int tipo, String pergunta, String resposta, String[] opcoes){
        this.tipo = tipo;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.opcoes = opcoes;
        this.pontos = 5;
    }

    /**
     * Construtor para perguntas com subtipo.
     *
     * @param tipo     O tipo da pergunta (1 para Artes, 2 para Ciências, 3 para Desporto).
     * @param subtipo  O subtipo da pergunta (1 para Futebol, 2 para Ski, 3 para Natação).
     * @param pergunta O texto da pergunta.
     * @param resposta A resposta correta da pergunta.
     * @param opcoes   As opções de resposta da pergunta.
     */
    public Pergunta(int tipo, int subtipo, String pergunta, String resposta, String[] opcoes){
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.opcoes = opcoes;
        this.pontos = 5;
    }

    /**
     * Construtor para perguntas com subtipo, opções fáceis e resposta adicional.
     *
     * @param tipo      O tipo da pergunta (1 para Artes, 2 para Ciências, 3 para Desporto).
     * @param subtipo   O subtipo da pergunta (1 para Futebol, 2 para Ski, 3 para Natação).
     * @param pergunta  O texto da pergunta.
     * @param resposta  A resposta correta da pergunta.
     * @param opcoes    As opções de resposta da pergunta.
     * @param opcoesEz  As opções fáceis de resposta da pergunta.
     * @param resposta2 A resposta adicional associada a perguntas específicas.
     */
    public Pergunta(int tipo, int subtipo, String pergunta, String resposta, String[] opcoes, String[] opcoesEz, String resposta2){
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.resposta2 = resposta2;
        this.opcoes = opcoes;
        this.opcoesEz = opcoesEz;
        this.pontos = 5;
    }

    /**
     * Construtor para perguntas com subtipo e opções fáceis.
     *
     * @param tipo     O tipo da pergunta (1 para Artes, 2 para Ciências, 3 para Desporto).
     * @param subtipo  O subtipo da pergunta (1 para Futebol, 2 para Ski, 3 para Natação).
     * @param pergunta O texto da pergunta.
     * @param resposta A resposta correta da pergunta.
     * @param opcoes   As opções de resposta da pergunta.
     * @param opcoesEz As opções fáceis de resposta da pergunta.
     */
    public Pergunta(int tipo, int subtipo, String pergunta, String resposta, String[] opcoes, String[] opcoesEz){
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.opcoes = opcoes;
        this.opcoesEz = opcoesEz;
        this.pontos = 5;
    }

    /**
     * Lê o input fornecido e inicializa os atributos da pergunta.
     *
     * @param a String contendo os dados da pergunta.
     */
    protected void leInput(String a){
        String[] input = a.split(";");
        setTipo(Integer.parseInt(input[0]));
        setSubtipo(Integer.parseInt(input[1]));
        setPergunta(input[2]);
        setResposta(input[3]);
        if (this.tipo == 3 && this.subtipo == 1){ // Trata das perguntas de Desporto de Futebol
            setResposta2(input[4]);
            for (int i = 0; i < opcoes.length; i++) {
                setOpcoes(i, input[5+i]);
                setOpcoesEz(i, input[9+i]);
            }
        }else if (input.length == 12){ //Trata das perguntas de Ciencias
            for (int i = 0; i < opcoesEz.length; i++) {
                setOpcoes(i, input[4+i]);
                setOpcoesEz(i, input[8+i]);
            }
        }else if (input.length == 6){ //Trata das perguntas de Desporto de V ou F
            setOpcoes(0, input[4]);
            setOpcoes(1, input[5]);
        }else{ //Trata das perguntas de Artes
            for (int i = 0; i < opcoes.length; i++) {
                setOpcoes(i, input[4+i]);
            }
        }
    }
    // Métodos, Getter e Setter

    /**
     * Obtém a pontuação da pergunta.
     *
     * @return A pontuação da pergunta.
     */
    public int calculaPontos() {
        int pontuacao = 0;
        return pontuacao;
    }

    /**
     * Obtém o tipo da pergunta.
     *
     * @return O tipo da pergunta.
     */
    public int getTipo() {
        return this.tipo;
    }

    /**
     * Obtém o subtipo da pergunta.
     *
     * @return O subtipo da pergunta.
     */
    public int getSubtipo() {
        return this.subtipo;
    }

    /**
     * Obtém o texto da pergunta.
     *
     * @return O texto da pergunta.
     */
    public String getPergunta() {
        return this.pergunta;
    }

    /**
     * Obtém a resposta correta da pergunta.
     *
     * @return A resposta correta da pergunta.
     */
    public String getResposta() {
        return this.resposta;
    }

    /**
     * Obtém as opções de resposta da pergunta.
     *
     * @return As opções de resposta da pergunta.
     */
    public String[] getOpcoes() {
        return this.opcoes;
    }

    /**
     * Obtém as opções fáceis de resposta da pergunta.
     *
     * @return As opções fáceis de resposta da pergunta.
     */
    public String[] getOpcoesEz() {
        return this.opcoesEz;
    }

    /**
     * Obtém a majoração associada à pergunta.
     *
     * @return A majoração associada à pergunta.
     */
    public int getMajoracao() {
        return this.majoracao;
    }

    /**
     * Obtém a pontuação inicial da pergunta.
     *
     * @return A pontuação inicial da pergunta.
     */
    public int getPontos() {
        return this.pontos;
    }

    /**
     * Obtém a resposta adicional da pergunta.
     *
     * @return A resposta adicional da pergunta.
     */
    public String getResposta2() {
        return this.resposta2;
    }

    // Métodos Setter

    /**
     * Define o texto da pergunta.
     *
     * @param pergunta O novo texto da pergunta.
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    /**
     * Define a resposta correta da pergunta.
     *
     * @param resposta A nova resposta correta da pergunta.
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * Define uma opção de resposta da pergunta.
     *
     * @param index O índice da opção a ser definida.
     * @param opcao A nova opção de resposta.
     */
    public void setOpcoes(int index, String opcao) {
        this.opcoes[index] = opcao;
    }

    /**
     * Define uma opção fácil de resposta da pergunta.
     *
     * @param index O índice da opção fácil a ser definida.
     * @param opcao A nova opção fácil de resposta.
     */
    public void setOpcoesEz(int index, String opcao) {
        this.opcoesEz[index] = opcao;
    }

    /**
     * Define a majoração associada à pergunta.
     *
     * @param majoracao A nova majoração da pergunta.
     */
    public void setMajoracao(int majoracao) {
        this.majoracao = majoracao;
    }

    /**
     * Define a pontuação inicial da pergunta.
     *
     * @param pontos A nova pontuação inicial da pergunta.
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * Define a resposta adicional da pergunta.
     *
     * @param resposta2 A nova resposta adicional da pergunta.
     */
    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    /**
     * Define o tipo da pergunta.
     *
     * @param tipo O novo tipo da pergunta.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Define o subtipo da pergunta.
     *
     * @param subtipo O novo subtipo da pergunta.
     */
    public void setSubtipo(int subtipo) {
        this.subtipo = subtipo;
    }
}