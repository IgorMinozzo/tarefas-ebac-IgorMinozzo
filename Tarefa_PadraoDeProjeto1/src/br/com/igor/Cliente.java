package br.com.igor;

public class Cliente {
    private String gradeRequest;
    private Boolean contrato;

    public Cliente(String gradeRequest, Boolean contrato) {
        this.gradeRequest = gradeRequest;
        this.contrato = contrato;
    }

    public String getGradeRequest() {
        return gradeRequest;
    }

    public void setGradeRequest(String gradeRequest) {
        this.gradeRequest = gradeRequest;
    }

    public Boolean getContrato() {
        return contrato;
    }

    public void setContrato(Boolean contrato) {
        this.contrato = contrato;
    }
}
