FROM node:lts-alpine3.14
WORKDIR /Simple_Homes_React
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 3000
CMD ["npm", "start"]