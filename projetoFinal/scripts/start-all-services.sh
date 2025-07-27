#!/bin/bash

echo "Iniciando todos os microserviços da MEMELÂNDIA..."

# Criar diretório de logs se não existir
mkdir -p logs

# Iniciar Usuario Service
echo "Iniciando Usuario Service na porta 8081..."
cd usuario-service
nohup java -jar target/usuario-service-0.0.1-SNAPSHOT.jar > ../logs/usuario-service.log 2>&1 &
USUARIO_PID=$!
echo "Usuario Service iniciado com PID: $USUARIO_PID"
cd ..

# Aguardar um pouco antes de iniciar o próximo serviço
sleep 5

# Iniciar Categoria Meme Service
echo "Iniciando Categoria Meme Service na porta 8082..."
cd categoria-meme-service
nohup java -jar target/categoria-meme-service-0.0.1-SNAPSHOT.jar > ../logs/categoria-meme-service.log 2>&1 &
CATEGORIA_PID=$!
echo "Categoria Meme Service iniciado com PID: $CATEGORIA_PID"
cd ..

# Aguardar um pouco antes de iniciar o próximo serviço
sleep 5

# Iniciar Meme Service
echo "Iniciando Meme Service na porta 8083..."
cd meme-service
nohup java -jar target/meme-service-0.0.1-SNAPSHOT.jar > ../logs/meme-service.log 2>&1 &
MEME_PID=$!
echo "Meme Service iniciado com PID: $MEME_PID"
cd ..

# Salvar PIDs em arquivo para facilitar o stop
echo $USUARIO_PID > logs/usuario-service.pid
echo $CATEGORIA_PID > logs/categoria-meme-service.pid
echo $MEME_PID > logs/meme-service.pid

echo ""
echo "Todos os serviços foram iniciados!"
echo "PIDs salvos em logs/*.pid"
echo ""
echo "URLs dos serviços:"
echo "- Usuario Service: http://localhost:8081"
echo "- Categoria Meme Service: http://localhost:8082"
echo "- Meme Service: http://localhost:8083"
echo ""
echo "Para parar todos os serviços, execute: ./stop-all-services.sh"
echo "Para ver os logs, execute: tail -f logs/*.log"

