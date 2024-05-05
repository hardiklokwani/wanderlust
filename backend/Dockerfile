#--------------Multi-Stage Build------------------#
#Stag-1
FROM node:21 AS backend-builder

WORKDIR /app

COPY . .

RUN npm i

#Stage-2
FROM node:21-slim

WORKDIR /app

COPY --from=backend-builder /app .

COPY .env.sample .env

EXPOSE 5000

CMD ["npm","start"]
