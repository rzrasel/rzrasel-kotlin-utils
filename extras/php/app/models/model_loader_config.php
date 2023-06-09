<?php
abstract class ModelLoaderConfig {
    public const rootDir = "model";
    private const direList = array(
        "menu",
    );
    public static function getDirList($dirList = array()) {
        $dataList = array();
        foreach(self::direList as $key) {
            $dataList[] = self::rootDir . "/" . $key;
        }
        if(empty($dirList)) {
            return $dataList;
        }
        if(!is_array($dirList)) {
            return $dataList;
        }
        return array_merge($dirList, $dataList);
    }
}
?>