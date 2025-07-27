#!/bin/bash

echo "Parando todos os microserviços da MEMELÂNDIA..."

# Verificar se os arquivos de PID existem
if [ -f "logs/usuario-service.pid" ]; then
    USUARIO_PID=$(cat logs/usuario-service.pid)
    echo "Parando Usuario Service (PID: $USUARIO_PID)..."
    kill $USUARIO_PID 2>/dev/null
    rm logs/usuario-service.pid
else
    echo "PID do Usuario Service não encontrado"
fi

if [ -f "logs/categoria-meme-service.pid" ]; then
    CATEGORIA_PID=$(cat logs/categoria-meme-service.pid)
    echo "Parando Categoria Meme Service (PID: $CATEGORIA_PID)..."
    kill $CATEGORIA_PID 2>/dev/null
    rm logs/categoria-meme-service.pid
else
    echo "PID do Categoria Meme Service não encontrado"
fi

if [ -f "logs/meme-service.pid" ]; then
    MEME_PID=$(cat logs/meme-service.pid)
    echo "Parando Meme Service (PID: $MEME_PID)..."
    kill $MEME_PID 2>/dev/null
    rm logs/meme-service.pid
else
    echo "PID do Meme Service não encontrado"
fi

echo ""
echo "Todos os serviços foram parados!"

