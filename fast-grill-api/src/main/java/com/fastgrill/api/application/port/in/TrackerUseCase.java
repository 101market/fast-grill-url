package com.fastgrill.api.application.port.in;

public interface TrackerUseCase {
    /**
     * shorten url 노출 요청 처리
     *
     * @param command
     */
    void impression(ImpressionCommand command);

    /**
     * shorten url click 요청 처리
     *
     * @param command
     * @return
     */
    String click(ClickCommand command);


    /**
     * shorten url click 후 전환 요청 처리
     *
     * @param command
     * @return
     */
    void convert(ConversionCommand command);
}
