package com.fastgrill.api.application.port.in;

public interface TrackingUseCase {
    /**
     * shorten url 노출 요청 처리
     * @param command
     */
    void impression(ImpressionCommand command);

    /**
     * shorten url click 요청 처리
     * @param command
     * @return
     */
    String click(ClickCommand command);
}
