namespace java com.kolev.chat

struct Message {
    1: required string userName
    2: required i64 timstamp
    4: optional string text
}

typedef list<Message> Messages

exception ChatUnavailable {
    1: string message;
}

service Chat {
    void ping()
    bool post(1: Message message) throws(1: ChatUnavailable unavailable)
    Messages pull()

}