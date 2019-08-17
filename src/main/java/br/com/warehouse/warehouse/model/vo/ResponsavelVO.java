package br.com.warehouse.warehouse.model.vo;

import java.time.LocalDate;

public class ResponsavelVO {

    private Integer idResponsavel;
    private String noResponsavel;
    private String email;
    private LocalDate dataNascimento;

    public ResponsavelVO(ResponsavelVOBuilder responsavelVOBuilder){
        this.idResponsavel = responsavelVOBuilder.idResponsavel;
        this.noResponsavel = responsavelVOBuilder.noResponsavel;
        this.email = responsavelVOBuilder.email;
        this.dataNascimento = responsavelVOBuilder.dataNascimento;
    }

    public ResponsavelVO(){

    }

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNoResponsavel() {
        return noResponsavel;
    }

    public void setNoResponsavel(String noResponsavel) {
        this.noResponsavel = noResponsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ResponsavelVO build(){
        return this;
    }


    public static class ResponsavelVOBuilder{
        private Integer idResponsavel;
        private String noResponsavel;
        private String email;
        private LocalDate dataNascimento;

        public ResponsavelVOBuilder setIdResponsavel(Integer idResponsavel) {
            this.idResponsavel = idResponsavel;
            return this;
        }

        public ResponsavelVOBuilder setNoResponsavel(String noResponsavel) {
            this.noResponsavel = noResponsavel;
            return this;
        }

        public ResponsavelVOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ResponsavelVOBuilder setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public ResponsavelVO build(){
            return new ResponsavelVO(this);
        }
    }
}
