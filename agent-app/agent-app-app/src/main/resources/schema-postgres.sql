CREATE EXTENSION IF NOT EXISTS vector;
CREATE TABLE IF NOT EXISTS vector_store (
                                            id VARCHAR(255) PRIMARY KEY,
    content TEXT,
    metadata JSONB,
    embedding VECTOR(1024)
    );

CREATE INDEX IF NOT EXISTS vector_store_embedding_idx
    ON vector_store
    USING ivfflat (embedding vector_cosine_ops);
