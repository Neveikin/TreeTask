# Развертывание Red-Black Tree Visualizer

## Максимально простое решение для 1 дня

### 1. Развертывание бэкенда на Railway

1. **Загрузите код на GitHub**
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   git remote add origin <your-repo-url>
   git push -u origin main
   ```

2. **Соберите проект локально**
   ```bash
   mvn clean package -DskipTests
   ```

3. **Развертывание на Railway**
   - Зайдите в [railway.app](https://railway.app)
   - Нажмите "New Project" → "Deploy from GitHub repo"
   - Выберите ваш репозиторий
   - Railway автоматически определит Java проект и соберет его
   - После сборки получите URL вашего бэкенда (например: `https://your-app.up.railway.app`)
   
   **Важно**: Проект настроен на Java 21 для совместимости с Railway

### 2. Развертывание фронтенда на Vercel

1. **Загрузите фронтенд**
   - Создайте новый репозиторий для фронтенда или используйте подпапку
   - Скопируйте папку `frontend` в отдельный репозиторий

2. **Развертывание на Vercel**
   - Зайдите в [vercel.com](https://vercel.com)
   - Нажмите "New Project"
   - Подключите GitHub репозиторий с фронтендом
   - В настройках сборки добавьте переменную окружения:
     ```
     API_URL=https://your-app.up.railway.app/api/tree
     ```
   - Нажмите "Deploy"

### 3. Готово!

После развертывания:
- **Бэкенд**: `https://your-app.up.railway.app` (Swagger доступен по `/swagger-ui.html`)
- **Фронтенд**: `https://your-app.vercel.app`

### Проверка работы

1. Откройте фронтенд URL
2. Попробуйте добавить узел в дерево
3. Проверьте визуализацию и статистику

### Если что-то не работает:

- **CORS ошибки**: Убедитесь что фронтенд URL добавлен в `@CrossOrigin` в `TreeController.java`
- **API недоступен**: Проверьте что Railway приложение запущено и доступно
- **Переменные окружения**: Убедитесь что `API_URL` в Vercel указывает на правильный Railway URL

### Для быстрой отладки:

```bash
# Локальный запуск бэкенда
mvn spring-boot:run

# Локальный запуск фронтенда
cd frontend
python3 -m http.server 3000
# Откройте http://localhost:3000
```

Это решение полностью бесплатное для вашего случая использования (несколько посетителей на 1 день).
