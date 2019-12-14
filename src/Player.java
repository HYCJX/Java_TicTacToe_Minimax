public class Player {

    private DecisionMaker decisionMaker;
    private Symbol symbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setDecisionMaker(DecisionMaker decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void play(Board board) {
        assert(decisionMaker != null);
        decisionMaker.play(symbol, board);
    }
}
