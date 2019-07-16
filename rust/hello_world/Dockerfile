#FROM rust:latest
FROM rust:1.31

WORKDIR /usr/src/myapp

COPY . .

RUN cargo build --release

RUN cargo install --path .

CMD ["/usr/local/cargo/bin/myapp"]