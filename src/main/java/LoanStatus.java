public enum LoanStatus {
    ACTIVE("Utlånad"), OLD("Återlämnad"), INVALID("Ej tillgänlig"), BOOKSTOLEN("Stulen");

    private String status;

    LoanStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
