package com.alurachallenges.conversordemonedas.modelos;

import com.google.gson.JsonObject;

public class Moneda {
    private double tasaCopAUsd;
    private double tasaUsdACop;
    private double tasaCopAEur;
    private double tasaEurACop;
    private double tasaCopAChf;
    private double tasaChfACop;

    public Moneda(API api) throws Exception {
        actualizarTasasDeCambio(api);
    }

    public void actualizarTasasDeCambio(API api) throws Exception {
        JsonObject rates = api.getExchangeRates();

        tasaCopAUsd = rates.get("USD").getAsDouble();
        tasaUsdACop = 1 / tasaCopAUsd;
        tasaCopAEur = rates.get("EUR").getAsDouble();
        tasaEurACop = 1 / tasaCopAEur;
        tasaCopAChf = rates.get("CHF").getAsDouble();
        tasaChfACop = 1 / tasaCopAChf;
    }

    public double convertirCopAUsd(double cop) {
        return cop * tasaCopAUsd;
    }

    public double convertirUsdACop(double usd) {
        return usd * tasaUsdACop;
    }

    public double convertirCopAEur(double cop) {
        return cop * tasaCopAEur;
    }

    public double convertirEurACop(double eur) {
        return eur * tasaEurACop;
    }

    public double convertirCopAChf(double cop) {
        return cop * tasaCopAChf;
    }

    public double convertirChfACop(double chf) {
        return chf * tasaChfACop;
    }
}
