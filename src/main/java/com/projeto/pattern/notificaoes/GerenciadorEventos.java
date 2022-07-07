package com.projeto.pattern.notificaoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorEventos {

        Map<String, List<ObservadorEventos>> listeners = new HashMap<>();

        public GerenciadorEventos(String... operations) {
            for (String operation : operations) {
                this.listeners.put(operation, new ArrayList<>());
            }
        }

        public void seguir(String eventType, ObservadorEventos listener) {
            List<ObservadorEventos> users = listeners.get(eventType);
            users.add(listener);
        }

        public void naoSeguir(String eventType, ObservadorEventos listener) {
            List<ObservadorEventos> users = listeners.get(eventType);
            users.remove(listener);
        }

        public void notificar(String eventType, String mensagem) {
            List<ObservadorEventos> users = listeners.get(eventType);
            for (ObservadorEventos listener : users) {
                listener.update(eventType, mensagem);
            }
        }
    }

