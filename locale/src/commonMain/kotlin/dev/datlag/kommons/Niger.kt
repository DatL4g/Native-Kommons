package dev.datlag.kommons


data object Niger : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NER")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(562)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(227)
    override val continent: Continent = Continent.Africa
}