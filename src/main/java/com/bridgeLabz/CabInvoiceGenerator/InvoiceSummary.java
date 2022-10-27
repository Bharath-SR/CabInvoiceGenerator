package com.bridgeLabz.CabInvoiceGenerator;


    public class InvoiceSummary {
        private final int nuberOfRides;
        private final double totalFare;
        private final double averageFare;

        public InvoiceSummary(int nuberOfRides, double totalFare) {
            this.nuberOfRides = nuberOfRides;
            this.totalFare = totalFare;
            this.averageFare =this.totalFare/nuberOfRides;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InvoiceSummary summary = (InvoiceSummary) o;
            return nuberOfRides == summary.nuberOfRides && Double.compare(summary.totalFare, totalFare) == 0 && Double.compare(summary.averageFare, averageFare) == 0;
        }

    }
