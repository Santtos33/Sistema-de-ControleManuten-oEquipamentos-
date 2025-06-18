
package model;

import java.util.Date;

    public class Manutencao {
        private int id;
        private String tipo; // "preventiva" ou "corretiva"
        private String descricao;
        private Date data;
        private int equipamentoId;

        public Manutencao() {}

        public Manutencao(int id, String tipo, String descricao, Date data, int equipamentoId) {
            this.id = id;
            this.tipo = tipo;
            this.descricao = descricao;
            this.data = data;
            this.equipamentoId = equipamentoId;
        }

        // Getters e Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }

        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }

        public Date getData() { return data; }
        public void setData(Date data) { this.data = data; }

        public int getEquipamentoId() { return equipamentoId; }
        public void setEquipamentoId(int equipamentoId) { this.equipamentoId = equipamentoId; }
    }


