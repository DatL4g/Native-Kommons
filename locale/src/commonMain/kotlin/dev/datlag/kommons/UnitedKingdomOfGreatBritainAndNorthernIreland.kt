package dev.datlag.kommons


data object UnitedKingdomOfGreatBritainAndNorthernIreland : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GB")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GBR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(826)
    override val domain: Country.Code.Domain = Country.Code.Domain("uk")
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(44)
    override val continent: Continent = Continent.Europe
}