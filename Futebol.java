/**
 * Classe que representa uma pergunta de Futebol, um subtipo de perguntas de Desporto.
 *
 * @version 1.0
 * @author Joao Furukawa
 * @author Mateus Lima
 */
public class Futebol extends Desporto {

    /**
     * Construtor para perguntas de Futebol.
     *
     * @param pergunta  O texto da pergunta.
     * @param resposta  A resposta correta da pergunta.
     * @param opcoes    As opções de resposta da pergunta.
     * @param opcoesEz  As opções fáceis de resposta da pergunta.
     * @param resposta2 A resposta adicional associada a perguntas específicas.
     */
    public Futebol(String pergunta, String resposta, String[] opcoes, String[] opcoesEz,String resposta2){
        super(3,1,pergunta, resposta, opcoes, opcoesEz,resposta2);
        this.majoracao = 1;
    }

    /**
     * Calcula a pontuação para perguntas de Futebol.
     *
     * @return A pontuação calculada.
     */
    @Override
    public int calculaPontos(){
        int pontuacao = this.pontos + this.majoracao + 3;
        return pontuacao;
    }
}
