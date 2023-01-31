package com.cloud.nativ.networkui.domain.graphql;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-29 5:52 p.m.
 */
public class NetworkGraphQueryResponse {

    private Data data;

    public NetworkGraphQueryResponse() {
        //
    }

    public NetworkGraphQueryResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NetworkGraphQueryResponse{" +
                "data=" + data +
                '}';
    }
}
