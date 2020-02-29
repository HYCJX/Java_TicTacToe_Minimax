public enum Symbol {
  CIRCLE {
    @Override
    public String toString() {
      return "O";
    }
  },
  CROSS {
    @Override
    public String toString() {
      return "X";
    }
  },
  DEFAULT {
    @Override
    public String toString() {
      return "_";
    }
  }
}
