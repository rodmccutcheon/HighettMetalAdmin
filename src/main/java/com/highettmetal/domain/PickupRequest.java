package com.highettmetal.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class PickupRequest {

    private Bin[] bins;

    @JsonProperty("scrap_types")
    private String[] scrapTypes;

    @JsonProperty("client_code")
    private String clientCode;

    private static class Bin {

        @JsonProperty("bin_name")
        private String binName;
        private int quantity;

        public String getBinName() {
            return binName;
        }

        public void setBinName(String binName) {
            this.binName = binName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Bin{" +
                    "binName='" + binName + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    public Bin[] getBins() {
        return bins;
    }

    public void setBins(Bin[] bins) {
        this.bins = bins;
    }

    public String[] getScrapTypes() {
        return scrapTypes;
    }

    public void setScrapTypes(String[] scrapTypes) {
        this.scrapTypes = scrapTypes;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    @Override
    public String toString() {
        return "PickupRequest{" +
                "bins=" + Arrays.toString(bins) +
                ", scrapTypes=" + Arrays.toString(scrapTypes) +
                ", clientCode='" + clientCode + '\'' +
                '}';
    }
}
