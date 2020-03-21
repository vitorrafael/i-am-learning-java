package com.vitorrafael.javamarathon.JDBC.classes;

public class Customer {

        private Integer id;
        private String cpf;
        private String name;

        public Customer() {
        }

        public Customer(String cpf, String name) {
                this.cpf = cpf;
                this.name = name;
        }

        public Customer(Integer id, String cpf, String name) {
                this.id = id;
                this.cpf = cpf;
                this.name = name;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Customer customer = (Customer) o;

                return id != null ? id.equals(customer.id) : customer.id == null;
        }

        @Override
        public int hashCode() {
                return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
                return "Customer{" +
                        "id=" + id +
                        ", cpf='" + cpf + '\'' +
                        ", name='" + name + '\'' +
                        '}';
        }
}
