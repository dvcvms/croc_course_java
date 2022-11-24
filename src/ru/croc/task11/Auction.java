package ru.croc.task11;

import java.time.LocalDateTime;

public class Auction {

    private volatile int finalBid;
    private volatile String finalBidder = null;
    private final LocalDateTime endTimeOfTheBid;


    public Auction(int initialBid, LocalDateTime endTimeOfTheBid) {
        this.finalBid = initialBid;
        this.endTimeOfTheBid = endTimeOfTheBid;
    }

    public synchronized void placeBet(int newBid, String bidder) {
        LocalDateTime dateNewBid = LocalDateTime.now();
        if (newBid > this.finalBid && dateNewBid.isBefore(this.endTimeOfTheBid)) {
            this.finalBid = newBid;
            this.finalBidder = bidder;
        }
    }

    public String getWinner() {
        if (LocalDateTime.now().isAfter(this.endTimeOfTheBid)) {
            if (this.finalBidder == null) {
                return "The bidder wasn't detected!";
            }
            return this.finalBidder;
        }
        return "Bidding is still underway!";
    }
}
