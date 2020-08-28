package com.gai.baselearn.enums;

public enum VideoStatus {
    Draft, Review, Published;

    public static void main(String[] args) {
        System.out.println(VideoStatus.Draft.name());
        System.out.println(VideoStatus.Review.name());
        System.out.println(VideoStatus.Published.name());

        System.out.println(VideoStatus.Draft);
        System.out.println(VideoStatus.Review);
        System.out.println(VideoStatus.Published.ordinal());
    }
}
