package DiskWork.DiskWork.controller;

import DiskWork.DiskWork.model.TreeNode;
import DiskWork.DiskWork.service.TreeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tree")
@CrossOrigin(origins = "*")
@Tag(name = "Red-Black Tree API", description = "API для работы с Red-Black деревом")
public class TreeController {

    private final TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping("/insert")
    @Operation(summary = "Вставить узел в дерево", description = "Добавляет новый узел с указанным значением в Red-Black дерево")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Узел успешно вставлен"),
        @ApiResponse(responseCode = "400", description = "Некорректное значение")
    })
    public ResponseEntity<TreeNode> insert(
            @Parameter(description = "Значение для вставки", required = true, example = "10")
            @RequestParam Integer value) {
        TreeNode node = treeService.insert(value);
        return ResponseEntity.ok(node);
    }

    @GetMapping("/search")
    @Operation(summary = "Найти узел в дереве", description = "Ищет узел с указанным значением в дереве")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Узел найден"),
        @ApiResponse(responseCode = "404", description = "Узел не найден")
    })
    public ResponseEntity<TreeNode> search(
            @Parameter(description = "Значение для поиска", required = true, example = "10")
            @RequestParam Integer value) {
        TreeNode node = treeService.search(value);
        return node != null ? ResponseEntity.ok(node) : ResponseEntity.notFound().build();
    }

    @GetMapping("/nodes")
    @Operation(summary = "Получить все узлы дерева", description = "Возвращает все узлы дерева в in-order обходе (отсортированные)")
    @ApiResponse(responseCode = "200", description = "Список узлов получен")
    public ResponseEntity<List<Integer>> getAllNodes() {
        List<Integer> nodes = treeService.getAllNodes();
        return ResponseEntity.ok(nodes);
    }

    @DeleteMapping("/clear")
    @Operation(summary = "Очистить дерево", description = "Удаляет все узлы из дерева")
    @ApiResponse(responseCode = "200", description = "Дерево успешно очищено")
    public ResponseEntity<Void> clearTree() {
        treeService.clearTree();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/root")
    @Operation(summary = "Получить корень дерева", description = "Возвращает корневой узел со всей структурой дерева")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Корень получен"),
        @ApiResponse(responseCode = "404", description = "Дерево пусто")
    })
    public ResponseEntity<TreeNode> getRoot() {
        TreeNode root = treeService.getRoot();
        return root != null ? ResponseEntity.ok(root) : ResponseEntity.notFound().build();
    }

    @GetMapping("/statistics/height")
    @Operation(summary = "Получить высоту дерева", description = "Возвращает высоту Red-Black дерева")
    @ApiResponse(responseCode = "200", description = "Высота дерева получена")
    public ResponseEntity<Integer> getTreeHeight() {
        int height = treeService.getTreeHeight();
        return ResponseEntity.ok(height);
    }

    @GetMapping("/statistics/red-black-ratio")
    @Operation(summary = "Получить соотношение красных/черных узлов", description = "Возвращает количество красных, черных и общее число узлов в дереве")
    @ApiResponse(responseCode = "200", description = "Статистика по цветам узлов получена")
    public ResponseEntity<Map<String, Integer>> getRedBlackRatio() {
        Map<String, Integer> ratio = treeService.getRedBlackRatio();
        return ResponseEntity.ok(ratio);
    }

    @GetMapping("/statistics/node-depth")
    @Operation(summary = "Получить глубину узла", description = "Возвращает глубину указанного узла от корня")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Глубина узла получена"),
        @ApiResponse(responseCode = "200", description = "Узел не найден, возвращено -1")
    })
    public ResponseEntity<Integer> getNodeDepth(
            @Parameter(description = "Значение узла для поиска глубины", required = true, example = "10")
            @RequestParam Integer value) {
        int depth = treeService.getNodeDepth(value);
        return ResponseEntity.ok(depth);
    }

    @GetMapping("/statistics/nodes-by-level")
    @Operation(summary = "Получить распределение узлов по уровням", description = "Возвращает список с количеством узлов на каждом уровне дерева для построения графика")
    @ApiResponse(responseCode = "200", description = "Распределение узлов по уровням получено")
    public ResponseEntity<List<Integer>> getNodesByLevel() {
        List<Integer> nodesByLevel = treeService.getNodesByLevel();
        return ResponseEntity.ok(nodesByLevel);
    }
}
