/**
 * Classe que representa uma pergunta de Ciências, um tipo de pergunta.
 *
 * @version 1.0
 * @author Joao Furukawa
 * @author Mateus Lima
 */
public class Ciencias extends Pergunta{
    /**
     * Construtor para perguntas de Ciências.
     *
     * @param pergunta  O texto da pergunta.
     * @param resposta  A resposta correta da pergunta.
     * @param opcoes    As opções de resposta da pergunta.
     * @param opcoesEz  As opções fáceis de resposta da pergunta.
     */
    public Ciencias(String pergunta, String resposta, String[] opcoes, String[] opcoesEz){
        super(2,0,pergunta, resposta, opcoes, opcoesEz);
        this.majoracao = 5;
    }
    @Override

    /**
     * Calcula a pontuação para perguntas de Ciências.
     *
     * @return A pontuação calculada.
     */
    public int calculaPontos(){
        int pontuacao = this.pontos + this.majoracao;
        return pontuacao;
    }
}
