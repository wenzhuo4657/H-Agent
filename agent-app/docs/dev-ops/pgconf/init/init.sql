-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS H-agent;

-- 切换到新创建的数据库
\c H-agent;

-- 创建 vector 扩展（如果不存在）
CREATE EXTENSION IF NOT EXISTS vector;

-- 创建 vector_store 表（如果不存在）
CREATE TABLE IF NOT EXISTS vector_store (
    id VARCHAR(255) PRIMARY KEY,
    content TEXT,
    metadata JSONB,
    embedding VECTOR(1024)
);

-- 创建嵌入向量的索引（如果不存在）
CREATE INDEX IF NOT EXISTS vector_store_embedding_idx
    ON vector_store
    USING ivfflat (embedding vector_cosine_ops);

